package be.kdg.view;

import javafx.geometry.Insets;
import javafx.scene.text.Font;

/**
 * @author Laura Van den Brande
 * @version 1.0 23/02/2019 12:06
 */
public class ViewConstants {
    //Algemeen
    public static final int BUTTON_WIDTH = 150;
    public static final int COMBOBOX_WIDTH_LARGE = 200;
    public static final int COMBOBOX_WIDTH_MEDIUM = 160;
    public static final int LABEL_WIDTH = 100;
    public static final int TEXTFIELD_WIDTH = 200;

    // VBox
    public static final Double SPACING_REGULAR = 10.0;
    public static final Double SPACING_SMALL = 5.0;
    public static final Insets INSETS_REGULAR = new Insets(30, 60, 30, 60);
    public static final Insets INSETS_SUBGROUP = new Insets(0,0,20,0);
    public static final Insets INSETS_BOTTOM_BUTTONS = new Insets(20,0,0,0);

    // GridPane
    public static final int GRID_HGAP = 10;
    public static final int GRID_VGAP = 10;
    public static final Insets GRID_PADDING = new Insets(10);
    public static final Insets GRID_PADDING_LARGE = new Insets(30);

    // Style
    public static final String WRONG_ANSWER = "-fx-background-color: lightpink; -fx-border-color: red";
    public static final String CORRECT_ANSWER = "-fx-background-color: palegreen; -fx-border-color: green";
    public static final String IMG_SHADOW = "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 )";
    public static final String LABEL_LESS_IMPORTANT = "-fx-text-fill: darkgrey";
    public static final Font LABEL_LARGE = Font.font(20);
}
