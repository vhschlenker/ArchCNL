package org.archcnl.kotlinparser.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class ImportDeclarationVisitorTest {

    @Test
    void testImportListFromComplexClass() throws IOException {
        var namedFileContext = TestHelper.getKotlinFileContextFromFile("ComplexClass.kt");

        var importDeclarationVisitor =
                new ImportDeclarationVisitor(namedFileContext.getRulesNames());
        importDeclarationVisitor.visit(namedFileContext.getFileContext());

        var imports = importDeclarationVisitor.getImports();

        assertEquals(3, imports.size());
        assertEquals("example.subpackage.ClassInSubpackage", imports.get(0).getName());
        assertEquals("ClassInSubpackage", imports.get(0).getSimpleName());
        assertEquals("example.anotherPackage.AnotherClass", imports.get(1).getName());
        assertEquals("AnotherClass", imports.get(1).getSimpleName());
        assertEquals("java.util", imports.get(2).getName());
        assertEquals("util", imports.get(2).getSimpleName());
    }
}