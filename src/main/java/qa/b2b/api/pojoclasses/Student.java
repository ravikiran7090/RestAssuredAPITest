package qa.b2b.api.pojoclasses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Getter
@AllArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Builder
public class Student {

    private int id;
    private String firstname;
    private String lastname;
    private String email;


    public static StudentBuilder1 builder1() {
        return new StudentBuilder1();
    }

//Sub Class for builder design pattern

    public static class StudentBuilder1 {
        private int id;
        private String firstname;
        private String lastname;
        private String email;



        public StudentBuilder1 setId(int id) {
            this.id = id;
            return this;
        }

        public StudentBuilder1 setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public StudentBuilder1 setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public StudentBuilder1 setEmail(String email) {
            this.email = email;
            return this;
        }

        public Student perform() {
            return new Student(this.id, this.firstname, this.lastname, this.email);
        }
    }

}
