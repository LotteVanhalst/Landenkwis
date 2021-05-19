package be.kdg.view.quiz;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.util.Duration;

/**
 * @author Lotte Vanhalst
 * @version 1.0 2/03/2019 23:58
 */
public class StopwatchTransition extends Transition {
    private final QuizView view;

    StopwatchTransition(QuizView view){
        this.view = view;
        this.setCycleDuration(Duration.seconds(10));
        this.setInterpolator(Interpolator.LINEAR);
    }

    protected void interpolate (double frac){
        // this.view.getLblTijdRest().setText(String.format("%.2f", frac*10));
        this.view.getIndicatorTijd().setProgress(frac);
    }
}
