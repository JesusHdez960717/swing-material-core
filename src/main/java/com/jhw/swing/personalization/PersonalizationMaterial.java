package com.jhw.swing.personalization;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.jhw.utils.jackson.JACKSON;
import java.awt.Color;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
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
            System.out.println("Error cargando personalización de material. Usando por defecto.");
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

    private boolean collapse_slow = true;

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

}
