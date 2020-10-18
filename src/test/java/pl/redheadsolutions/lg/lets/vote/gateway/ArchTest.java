package pl.redheadsolutions.lg.lets.vote.gateway;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("pl.redheadsolutions.lg.lets.vote.gateway");

        noClasses()
            .that()
            .resideInAnyPackage("pl.redheadsolutions.lg.lets.vote.gateway.service..")
            .or()
            .resideInAnyPackage("pl.redheadsolutions.lg.lets.vote.gateway.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..pl.redheadsolutions.lg.lets.vote.gateway.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
