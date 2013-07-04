package org.dbdoclet.doclet.docbook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.dbdoclet.doclet.DocletException;
import org.junit.Test;

import com.sun.tools.javadoc.RootDocImpl;

public class AnnotationTests extends AbstractTestCase {

    @Test
    public void testAnnotationJAXBElement() throws DocletException {

        String srcpath = sourcePath + "org/dbdoclet/music/MusicXmlElement.java";
        String classpath = sourcePath + ":lib/jaxb-api.jar";

        RootDocImpl root = javadoc(new String[] { srcpath }, classpath, new String[][] { { "-nostatistics" } });

        if (root == null) {
            fail("RootDoc == null");
            return;
        }

        DocBookDoclet.start(root);

        String value = xpath("//db:modifier[. = '@Deprecated']");
        assertEquals("@Deprecated", value);
    }
}
