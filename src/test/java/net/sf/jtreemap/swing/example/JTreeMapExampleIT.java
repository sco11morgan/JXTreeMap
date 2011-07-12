/*
 * Copyright (c) 2011 by Scott Morgan
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package net.sf.jtreemap.swing.example;

import net.sf.jtreemap.swing.TreeMapNode;
import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class JTreeMapExampleIT {

    private FrameFixture window;

    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    @After
    public void teardown() throws Exception {
        if (window != null) {
            window.cleanUp();
        }
    }

    @Test
    public void testPerformance() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(JTreeMapExampleIT.class.getResourceAsStream("/market.tm3")));
        final BuilderTM3 builder = new BuilderTM3(reader);

        final TreeMapNode node = builder.getRoot();
        assertThat(builder.getRoot().getChildren().size(), is(4));
        assertThat(builder.getRoot().getChildren().get(0).getLabel(), is("UK"));
        assertThat(builder.getRoot().getChildren().get(1).getLabel(), is("US"));
        assertThat(builder.getRoot().getChildren().get(2).getLabel(), is("AU"));
        assertThat(builder.getRoot().getChildren().get(3).getLabel(), is("JP"));

        final JTreeMapExample frame = GuiActionRunner.execute(new GuiQuery<JTreeMapExample>() {
            protected JTreeMapExample executeInEDT() {
                return new JTreeMapExample(builder);
            }
        });
        window = new FrameFixture(frame);
        window.show(); // shows the frame to tes

//        GuiActionRunner.execute(new GuiTask() {
//            @Override
//            protected void executeInEDT() throws Throwable {
////                frame.setWeight("Market Cap");
//                frame.repaint();
//            }
//        });
    }

}
