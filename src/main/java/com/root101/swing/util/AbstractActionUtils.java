/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class AbstractActionUtils {

    public static final String KEY_BACKGROUND = "BACKGROUND";
    public static final String KEY_FOREGROUND = "FOREGROUND";

    public static AbstractAction from(ImageIcon icon) {
        return new AbstractAction("empty", icon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                return;
            }
        };
    }

    public static AbstractAction from(String name, ImageIcon icon) {
        return new AbstractAction(name, icon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                return;
            }
        };
    }

    public static AbstractAction from(String name, ImageIcon icon, String tooltip, ActionListener l) {
        AbstractAction a = new AbstractAction(name, icon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.actionPerformed(e);
            }
        };
        a.putValue(Action.SHORT_DESCRIPTION, tooltip);
        return a;
    }
}
