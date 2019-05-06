<div align=center>
<img src="https://raw.githubusercontent.com/pzque/peaze/master/doc/peaze-newlogo.png" width="300" alt="peaze logo"/>
</div>

# Peaze
A lisp-like programming language running on JVM.

## About Peaze
Peaze is a lisp-like programming language. It has extreme flexible syntax just like lisp and provides easy access to Java frameworks.

The kernel features of Peaze include lexical scope, first-class procedures, proper treatment of tail calls, continuations, user-defined records, libraries, exceptions, and hygienic macro expansion.

Peaze is implemented with java8, currently the AST interpreter is under developing. The developing of the interpreter is in a very early stage, only a few features are supported. You could see more details at [Roadmap](#roadmap).

## Examples
### 1. A runnable example that calculates the n'th fibnacci number:

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

### 2. A runnable example that demonstrates the lexical closure feature:

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

## Try it
To run our interpreter. You need to build this project first:

1. Install maven in your system.
2. Clone this repository by:
```
git clone https://github.com/pzque/peaze.git
```
3. Build this project by running commands:
```
cd peaze
mvn package
```

After the building process, you'll get the executable jar file in the "target" folder. It will be named "peaze-0.0.1-jar-with-dependencies.jar", which is the main entry of our interpreter.

We provides several Peaze source files in the "examples" folder, now you could run them with our interpreter. For instance:

```
cd examples
java -jar ../target/peaze-0.0.1-jar-with-dependencies.jar fib.pz
```
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
