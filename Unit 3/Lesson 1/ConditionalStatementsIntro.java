//       || means or  - if any value is true, it outputs true
//       && means and - both values must be true to output true
//       !  means not

// De Morgan's Law: 
// !(A || B) == !A && !B
// !(A && B) == !A || !B

//In math, there are many rules, such as:
//- the commutative law:  A+B = B+A            thus A || B == B || A
//- the associative law:  A(B*C) = B(A*C)      thus A||(B||C) == B||(A||C)
//- the distributive law: A*(B+C) = A*B + A*C  thus A||(B&&C) == (A||B)&&(A||C)
//          - This is not true for math when A+(B*C) != A*B + A*C

public class ConditionalStatementsIntro{
    
}