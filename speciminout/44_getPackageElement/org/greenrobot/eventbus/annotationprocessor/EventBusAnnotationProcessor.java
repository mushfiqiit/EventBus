package org.greenrobot.eventbus.annotationprocessor;

import static net.ltgt.gradle.incap.IncrementalAnnotationProcessorType.AGGREGATING;

import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import net.ltgt.gradle.incap.IncrementalAnnotationProcessor;

@SupportedAnnotationTypes("org.greenrobot.eventbus.Subscribe")
@SupportedOptions(value = {"eventBusIndex", "verbose"})
@IncrementalAnnotationProcessor(AGGREGATING)
public class EventBusAnnotationProcessor extends AbstractProcessor {

  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
    throw new java.lang.Error();
  }

  private PackageElement getPackageElement(TypeElement subscriberClass) {
    Element candidate = subscriberClass.getEnclosingElement();
    while (!(candidate instanceof PackageElement)) {
      candidate = candidate.getEnclosingElement();
    }
    return (PackageElement) candidate;
  }
}
