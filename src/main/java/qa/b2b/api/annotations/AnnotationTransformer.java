package qa.b2b.api.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import qa.b2b.api.genericutils.TestUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {
    int count = 0;

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {


        try {
            if (count == 0) {
                TestUtils.getRunStatus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < TestUtils.testCaseName.size(); i++) {
            if (testMethod.getName().equalsIgnoreCase(TestUtils.testCaseName.get(i))) {

                //sets the dataprovider to all the test methods
                annotation.setDataProvider("dataProviderForIterations");

                //sets the retry analyser for all the test cases
                annotation.setDataProviderClass(TestUtils.class);

                //sets the priority for all the test cases based on the excel sheet input
                annotation.setPriority(Integer.parseInt(TestUtils.priority.get(i)));

                //sets the description for all the test cases based on the excel sheet input
                annotation.setDescription(TestUtils.testCaseDescription.get(i));

                //sets the invocation count for all the test cases based on the excel sheet input
                annotation.setInvocationCount(Integer.parseInt(TestUtils.invocationCount.get(i)));

                if (TestUtils.executeStatus.get(i).equalsIgnoreCase("no")) {
                    //sets the enabled parameter for all the test cases based on the excel sheet input
                    annotation.setEnabled(false);

                    break;
                }
            }
        }

        count++;
    }
}
