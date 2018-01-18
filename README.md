<img src="https://raw.githubusercontent.com/pzque/peaze/master/doc/peaze-logo-sqaure.png" width="300" alt="peaze logo"/>

# Peaze
Standard scheme implementation on JVM.

## About
Peaze is both a programming language and an implementation of that language, with supporting tools and documentation.

The goal of the project is to support all standard featrues described in [Revised6 Report on the Algorithmic Language Scheme (R6RS)](http://www.r6rs.org/), including first-class procedures, proper treatment of tail calls, continuations, user-defined records, libraries, exceptions, and hygienic macro expansion. Further more, 

## Roadmap
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
- [ ] list
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
