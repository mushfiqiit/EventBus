package org.greenrobot.eventbus.annotationprocessor;

import static net.ltgt.gradle.incap.IncrementalAnnotationProcessorType.AGGREGATING;

import de.greenrobot.common.ListMap;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import net.ltgt.gradle.incap.IncrementalAnnotationProcessor;

@SupportedAnnotationTypes("org.greenrobot.eventbus.Subscribe")
@SupportedOptions(value = {"eventBusIndex", "verbose"})
@IncrementalAnnotationProcessor(AGGREGATING)
public class EventBusAnnotationProcessor extends AbstractProcessor {

  public static final String OPTION_EVENT_BUS_INDEX = null;

  public static final String OPTION_VERBOSE = null;

  private final ListMap<TypeElement, ExecutableElement> methodsByClass = null;

  private boolean writerRoundDone;

  private int round;

  private boolean verbose;

  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
    Messager messager = processingEnv.getMessager();
    try {
      String index = processingEnv.getOptions().get(OPTION_EVENT_BUS_INDEX);
      if (index == null) {
        messager.printMessage(
            Diagnostic.Kind.ERROR,
            "No option " + OPTION_EVENT_BUS_INDEX + " passed to annotation processor");
        return false;
      }
      verbose = Boolean.parseBoolean(processingEnv.getOptions().get(OPTION_VERBOSE));
      int lastPeriod = index.lastIndexOf('.');
      String indexPackage = lastPeriod != -1 ? index.substring(0, lastPeriod) : null;
      round++;
      if (verbose) {
        messager.printMessage(
            Diagnostic.Kind.NOTE,
            "Processing round "
                + round
                + ", new annotations: "
                + !annotations.isEmpty()
                + ", processingOver: "
                + env.processingOver());
      }
      if (env.processingOver()) {
        if (!annotations.isEmpty()) {
          messager.printMessage(
              Diagnostic.Kind.ERROR,
              "Unexpected processing state: annotations still available after processing over");
          return false;
        }
      }
      if (annotations.isEmpty()) {
        return false;
      }
      if (writerRoundDone) {
        messager.printMessage(
            Diagnostic.Kind.ERROR,
            "Unexpected processing state: annotations still available after writing.");
      }
      collectSubscribers(annotations, env, messager);
      checkForSubscribersToSkip(messager, indexPackage);
      if (!methodsByClass.isEmpty()) {
        createInfoIndexFile(index);
      } else {
        messager.printMessage(Diagnostic.Kind.WARNING, "No @Subscribe annotations found");
      }
      writerRoundDone = true;
    } catch (RuntimeException e) {
      e.printStackTrace();
      messager.printMessage(
          Diagnostic.Kind.ERROR, "Unexpected error in EventBusAnnotationProcessor: " + e);
    }
    return true;
  }

  private void collectSubscribers(
      Set<? extends TypeElement> annotations, RoundEnvironment env, Messager messager) {
    throw new java.lang.Error();
  }

  private void checkForSubscribersToSkip(Messager messager, String myPackage) {
    throw new java.lang.Error();
  }

  private void createInfoIndexFile(String index) {
    throw new java.lang.Error();
  }
}
