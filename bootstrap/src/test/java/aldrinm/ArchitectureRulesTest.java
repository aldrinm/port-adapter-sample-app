package aldrinm;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ArchitectureRulesTest {

    @Test
    void checkHexRules() {
        JavaClasses classes = new ClassFileImporter().importPackages("aldrinm");

        //this is actually already enforced by the maven module configuration
        noClasses()
                .that()
                .resideInAPackage("aldrinm.application..")
                .should()
                .dependOnClassesThat()
                .resideInAPackage("aldrinm.adapter..")
                .check(classes);

        //these packages are in the same maven module
        noClasses()
                .that()
                .resideInAPackage("aldrinm.adapter.in..")
                .should()
                .dependOnClassesThat()
                .resideInAPackage("aldrinm.adapter.out..")
                .check(classes);

        //..and add more such checks
    }
}
