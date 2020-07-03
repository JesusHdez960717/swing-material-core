package com.jhw.swing.personalization;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.jhw.utils.jackson.JACKSON;
import java.awt.Color;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.jhw.swing.util.Utils;
import com.jhw.swing.util.icons.icon_ttf.IconTTF;
import com.jhw.swing.util.icons.icon_ttf.IconTTFJsonDeserializer;
import com.jhw.swing.util.icons.icon_ttf.IconTTFJsonSerializer;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialIcons;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class PersonalizationMaterial {
//-----------------------  COSAS DEL SINGLETON Y JSON  --------------------------------------------------------

    public static final File persMatJsonFile = new File(new File("").getAbsolutePath() + File.separator + "pers_mat.json");
    private static PersonalizationMaterial INSTANCE;

    private PersonalizationMaterial() {
        registerIconTTFModule();
    }

    public static PersonalizationMaterial getInstance() {
        if (INSTANCE == null) {
            INSTANCE = load();
        }
        return INSTANCE;
    }

    private static PersonalizationMaterial load() {
        PersonalizationMaterial act = new PersonalizationMaterial();
        try {//carga configuracion
            act = JACKSON.read(persMatJsonFile, PersonalizationMaterial.class);
        } catch (Exception e) {
            System.out.println("Error cargando personalizacion de material. Usando por defecto.");
            try {
                JACKSON.write(persMatJsonFile, act);
            } catch (Exception ex) {
                Logger.getLogger(PersonalizationMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return act;
    }

    private void registerIconTTFModule() {
        SimpleModule iconTTF = new SimpleModule("IconTTF Module");
        iconTTF.addSerializer(IconTTF.class, new IconTTFJsonSerializer());
        iconTTF.addDeserializer(IconTTF.class, new IconTTFJsonDeserializer());
        JACKSON.registerModule(iconTTF);
    }

//-----------------------  A PARTIR DE AQUI LOS ATRIBUTOS  --------------------------------------------------------
    //beep
    private boolean doBeep = true;//PersonalizationMaterial.getInstance().get

    private boolean useAntialiasing = true;
    private boolean useShadow = true;

    private boolean useAnimations = true;
    private boolean useAnimationsNotifications = true;

    private boolean double_delete_check = false;

    //button view, add, edit & cancel
    private Color colorButtonAdd = MaterialColors.GREEN_700;
    private Color colorButtonEdit = MaterialColors.BLUE_800;
    private Color colorButtonView = MaterialColors.BLUEGREY_700;
    private Color colorButtonCancel = MaterialColors.RED_700;

    //iconos view, edit & add para los proyectos
    private IconTTF iconButtonAdd = (IconTTF) MaterialIcons.ADD.deriveIcon(24f);
    private IconTTF iconButtonEdit = (IconTTF) MaterialIcons.EDIT.deriveIcon(24f);
    private IconTTF iconButtonView = (IconTTF) MaterialIcons.VIEW_MODULE.deriveIcon(24f);

    //money
    private Color colorMoneyPositive = Utils.darken(MaterialColors.GREEN_900);
    private Color colorMoneyNegative = MaterialColors.REDA_700;

    //text fields
    private Color colorAccent = MaterialColors.BLUEA_400;
    private Color colorWrong = MaterialColors.RED_800;

    //panel
    private Color colorBackgroundPanel = MaterialColors.WHITE;

    //foregrounds
    private Color colorForegroundForDark = MaterialColors.WHITE;
    private Color colorForegroundForWhite = MaterialColors.DARK_BLACK;

    //main
    private Color colorPrincipal = MaterialColors.BLUEA_200;
    private Color colorSecundary = MaterialColors.BLUE_900;

    //notificaciones principalmente
    private int secondsActive = 3;
    private Color colorDone = MaterialColors.GREEN_700;
    private Color colorError = MaterialColors.REDA_700;
    private Color colorInfo = MaterialColors.BLUE_700;

    public boolean isDoBeep() {
        return doBeep;
    }

    public void setDoBeep(boolean doBeep) {
        this.doBeep = doBeep;
    }

    public boolean isUseAntialiasing() {
        return useAntialiasing;
    }

    public void setUseAntialiasing(boolean useAntialiasing) {
        this.useAntialiasing = useAntialiasing;
    }

    public boolean isUseShadow() {
        return useShadow;
    }

    public void setUseShadow(boolean useShadow) {
        this.useShadow = useShadow;
    }

    public boolean isUseAnimations() {
        return useAnimations;
    }

    public void setUseAnimations(boolean useAnimations) {
        this.useAnimations = useAnimations;
    }

    public boolean isUseAnimationsNotifications() {
        return useAnimationsNotifications;
    }

    public void setUseAnimationsNotifications(boolean useAnimationsNotifications) {
        this.useAnimationsNotifications = useAnimationsNotifications;
    }

    public boolean isDouble_delete_check() {
        return double_delete_check;
    }

    public void setDouble_delete_check(boolean double_delete_check) {
        this.double_delete_check = double_delete_check;
    }

    public Color getColorButtonAdd() {
        return colorButtonAdd;
    }

    public void setColorButtonAdd(Color colorButtonAdd) {
        this.colorButtonAdd = colorButtonAdd;
    }

    public Color getColorButtonEdit() {
        return colorButtonEdit;
    }

    public void setColorButtonEdit(Color colorButtonEdit) {
        this.colorButtonEdit = colorButtonEdit;
    }

    public Color getColorButtonView() {
        return colorButtonView;
    }

    public void setColorButtonView(Color colorButtonView) {
        this.colorButtonView = colorButtonView;
    }

    public Color getColorButtonCancel() {
        return colorButtonCancel;
    }

    public void setColorButtonCancel(Color colorButtonCancel) {
        this.colorButtonCancel = colorButtonCancel;
    }

    public IconTTF getIconButtonAdd() {
        return iconButtonAdd;
    }

    public void setIconButtonAdd(IconTTF iconButtonAdd) {
        this.iconButtonAdd = iconButtonAdd;
    }

    public IconTTF getIconButtonEdit() {
        return iconButtonEdit;
    }

    public void setIconButtonEdit(IconTTF iconButtonEdit) {
        this.iconButtonEdit = iconButtonEdit;
    }

    public IconTTF getIconButtonView() {
        return iconButtonView;
    }

    public void setIconButtonView(IconTTF iconButtonView) {
        this.iconButtonView = iconButtonView;
    }

    public Color getColorMoneyPositive() {
        return colorMoneyPositive;
    }

    public void setColorMoneyPositive(Color colorMoneyPositive) {
        this.colorMoneyPositive = colorMoneyPositive;
    }

    public Color getColorMoneyNegative() {
        return colorMoneyNegative;
    }

    public void setColorMoneyNegative(Color colorMoneyNegative) {
        this.colorMoneyNegative = colorMoneyNegative;
    }

    public Color getColorAccent() {
        return colorAccent;
    }

    public void setColorAccent(Color colorAccent) {
        this.colorAccent = colorAccent;
    }

    public Color getColorWrong() {
        return colorWrong;
    }

    public void setColorWrong(Color colorWrong) {
        this.colorWrong = colorWrong;
    }

    public Color getColorBackgroundPanel() {
        return colorBackgroundPanel;
    }

    public void setColorBackgroundPanel(Color colorBackgroundPanel) {
        this.colorBackgroundPanel = colorBackgroundPanel;
    }

    public Color getColorForegroundForDark() {
        return colorForegroundForDark;
    }

    public void setColorForegroundForDark(Color colorForegroundForDark) {
        this.colorForegroundForDark = colorForegroundForDark;
    }

    public Color getColorForegroundForWhite() {
        return colorForegroundForWhite;
    }

    public void setColorForegroundForWhite(Color colorForegroundForWhite) {
        this.colorForegroundForWhite = colorForegroundForWhite;
    }

    public Color getColorPrincipal() {
        return colorPrincipal;
    }

    public void setColorPrincipal(Color colorPrincipal) {
        this.colorPrincipal = colorPrincipal;
    }

    public Color getColorSecundary() {
        return colorSecundary;
    }

    public void setColorSecundary(Color colorSecundary) {
        this.colorSecundary = colorSecundary;
    }

    public int getSecondsActive() {
        return secondsActive;
    }

    public void setSecondsActive(int secondsActive) {
        this.secondsActive = secondsActive;
    }

    public Color getColorDone() {
        return colorDone;
    }

    public void setColorDone(Color colorDone) {
        this.colorDone = colorDone;
    }

    public Color getColorError() {
        return colorError;
    }

    public void setColorError(Color colorError) {
        this.colorError = colorError;
    }

    public Color getColorInfo() {
        return colorInfo;
    }

    public void setColorInfo(Color colorInfo) {
        this.colorInfo = colorInfo;
    }

}
