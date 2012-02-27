package goson.typeloader;

import gw.config.CommonServices;
import gw.fs.IDirectory;
import gw.fs.IFile;
import gw.fs.IResource;
import gw.fs.ResourcePath;
import gw.lang.init.GosuInitialization;
import gw.lang.reflect.IPropertyInfo;
import gw.lang.reflect.IType;
import gw.lang.reflect.ITypeLoader;
import gw.lang.reflect.TypeSystem;
import gw.lang.reflect.module.*;
import gw.util.Pair;
import junit.framework.TestCase;
import goson.test.GosonTest;
import org.junit.Test;
import org.omg.CORBA.CTX_RESTRICT_SCOPE;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JSchemaTypeLoaderTest extends GosonTest {

    public void testBasicGosonTypes() {
        IType nameAndAge = TypeSystem.getByFullName("goson.examples.NameAndAge");
        assertNotNull(nameAndAge);
    }

    public void testNestedGosonTypes() {
        IType fullExample = TypeSystem.getByFullName("goson.examples.fullexample.Example");
        assertNotNull(fullExample);

        IType someType = TypeSystem.getByFullName("goson.examples.fullexample.Example.SomeType");
        assertNotNull(someType);

        IType nestedType = TypeSystem.getByFullName("goson.examples.fullexample.Example.SomeType.NestedType");
        assertNotNull(nestedType);
    }

    public void testRPCTypes() {
        assertNotNull(TypeSystem.getByFullName("goson.examples.rpc.Sample1"));

        assertNotNull(TypeSystem.getByFullName("goson.examples.rpc.Sample1.GetEmployee"));

        assertNull(TypeSystem.getByFullNameIfValid("goson.examples.rpc.Sample1.GetEmployee.Id"));

        assertNull(TypeSystem.getByFullNameIfValid("goson.examples.rpc.Sample1.UpdateEmployee"));
        assertNotNull(TypeSystem.getByFullName("goson.examples.rpc.Sample1.UpdateEmployee.Employee"));
    }

    public void testJsonTypes() {
        assertNotNull(TypeSystem.getByFullName("goson.examples.flickr.GalleriesList"));

        assertNotNull(TypeSystem.getByFullName("goson.examples.flickr.GalleriesList.Galleries"));

        //assertNull(TypeSystem.getByFullNameIfValid("goson.examples.RegularJson"));
    }

}