package practice.samplepetstore;

import org.testng.annotations.Test;
import practice.pojoclasses.Student;
import practice.pojoclasses.StudentBuilder;

public class BuilderDesignPatternTest {

    // To achieve immutability means can not provide the set methods to parameters
    // No. of parameters increases the readability decrease
    // if we want to ignore some fields/parameters, it becomes difficult to create multiple constructor,
    // so we go for builder design pattern

    @Test
    public void builderPattern() {

        Student student = StudentBuilder
                .builder()
                .setId(2345)
                .setFirstname("wqert")
                .setLastname("qwerfer")
                .setEmail("asdfg")
                .build();
        System.out.println(student);


    }
    @Test
    public void builderPattern1(){
        Student student = Student
                .builder1()
                .setEmail("awerfgt")
                .perform();
        System.out.println(student);

    }

    @Test
    public void builderPattern11() {
        Student student = Student
                .builder()
                .email("asdfg")
                .id(4345)
                .build();
        System.out.println(student);
    }
}
