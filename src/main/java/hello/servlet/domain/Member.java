package hello.servlet.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private long id;
    private String name;
    private int age;

    public Member() {}

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
