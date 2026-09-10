package org.greenrobot.eventbus.annotationprocessor;

import static net.ltgt.gradle.incap.IncrementalAnnotationProcessorType.AGGREGATING;

import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import net.ltgt.gradle.incap.IncrementalAnnotationProcessor;

@SupportedAnnotationTypes("org.greenrobot.eventbus.Subscribe")
@SupportedOptions(value = {"eventBusIndex", "verbose"})
@IncrementalAnnotationProcessor(AGGREGATING)
public class EventBusAnnotationProcessor extends AbstractProcessor {

  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
    throw new java.lang.Error();
  }

  private TypeElement getSuperclass(TypeElement type) {
    if (type.getSuperclass().getKind() == TypeKind.DECLARED) {
      TypeElement superclass =
          (TypeElement) processingEnv.getTypeUtils().asElement(type.getSuperclass());
      String name = superclass.getQualifiedName().toString();
      if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
        return null;
      } else {
        return superclass;
      }
    } else {
      return null;
    }
  }
}
