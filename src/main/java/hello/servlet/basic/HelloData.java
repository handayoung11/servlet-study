package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter
//Setter가 있어야 JSON lib가 JSON을 객체로 변환할 때 값을 넣어준다.
@Setter
public class HelloData {
    String username;
    int age;
}
