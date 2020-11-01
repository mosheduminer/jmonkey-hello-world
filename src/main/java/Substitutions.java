import org.lwjgl.*;
import com.oracle.svm.core.annotate.TargetClass;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.RecomputeFieldValue.Kind;
import com.oracle.svm.core.annotate.Alias;

@TargetClass(className = "org.lwjgl.MemoryUtilSun$AccessorUnsafe")
final class Target_org_lwjgl_MemoryUtilSun_AccessorUnsafe {
    @Alias @RecomputeFieldValue(kind = Kind.FieldOffset, declClass = java.nio.Buffer.class, name = "address") long address;
}

/** Dummy class to have a class with the file's name. */
public class Substitutions {
}