<img src="https://raw.githubusercontent.com/pzque/peaze/master/doc/peaze-logo-sqaure.png" width="300" alt="peaze logo"/>

# Peaze
Standard scheme implementation on JVM.

## About Peaze
Peaze is both a programming language and an implementation of that language, with supporting tools and documentation.

The main goal of this project is to implement the standard scheme language descriped in [Revised6 Report on the Algorithmic Language Scheme (R6RS)](http://www.r6rs.org/) and provide easy access to Java frameworks through compiling to JVM-bytecode. Peaze retains lisp's extreme flexbility and could benefit from the rich ecosystem of JVM.

The kernel features of Peaze include lexical scope, first-class procedures, proper treatment of tail calls, continuations, user-defined records, libraries, exceptions, and hygienic macro expansion.

Peaze is implemented with java8, currently the recurisive evaluation interpreter is in developing, the future release of Peaze will consist of a the to-JVM-bytecode compiler.

## try it
Up to now, Peaze intepreter has already supported some basic operations, first class procedures, recurisions and lexical closures. More details are list in [Roadmap](#roadmap)  Built with maven you'll get the executable jar file. Your could run the examples in "examples" directory using it: 

```
cd examples
java -jar ../target/peaze-0.0.1-jar-with-dependencies.jar fib.pz
```
This is an runnable example using recursion to evaluate fibnacci numbers:

```scheme
;;; iterative version
(define (fib-iter n)
        (define (fib-iter-help n f1 f2)
                (if (= n 1)
                  f1
                  (fib-iter-help (- n 1) f2 (+ f1 f2))))
        (fib-iter-help n 1 1))

;;; 55
(display (fib-iter 10))

;;; 1820529360
(display (fib-iter 60))
```


This is an runnable example demonstrating the lexical closure feature:

```scheme

;;; multi levels varaible capture
;;;

(define (addxyz x)
        (lambda (y)
                (lambda (z)
                        (+ x y z))))

(define add1-y-z (addxyz 1))
(define add1-2-z (add1-y-z 2))
(define add1-3-z (add1-y-z 3))
;;; 6
(display (add1-2-z 3))
;;; 14
(display (add1-3-z 10))
```

Note: There is 2 bugs currently and will be fixed later, so don't scare if you get a negative number when running `fib-iter` procedure with a bigger number argument:
1. The interpreter is implemented with recursive evalution which could cause Java stack overflow exception. I'll modify it to continuation-passing-style later, which could avoid the bug as well as naturlly supporting call/cc.
2. The internal number implementation uses Java's Integer and Double and doesn't handle number overflow, so if you calculate the sum of two big numbers will get a negative number due to the overflow. It wont't be fixed soon as it doesn't affect kernel features. When the kernel features is complete, I'll use BigInteger and BigDecimal to fix the bug.

## <span id="roadmap">Roadmap</span>
### kenerl features
- [x] s-expression
- [x] variable/function definition and reference
- [x] function call
- [x] first class function
- [x] lexical scope and closure
- [x] anonymous function: `lambda`
- [x] branch: `if`
- [ ] assign: `set!`
- [ ] first class continuation: `call/cc`
- [ ] macro

### basic types
- [ ] char
- [x] boolean
- [x] integer
- [x] rational
- [x] real
- [ ] complex
- [ ] string
- [ ] symbol
- [ ] pair(list)
- [ ] vector

### builtin procedures
- [x] +,-,*,/
- [x] =, <=, >=, <, > 
- [ ] cons, car, cdr

### builtin macros
- [ ] and
- [ ] or
- [ ] cond
- [ ] case
- [ ] let
- [ ] let*
- [ ] letrec
