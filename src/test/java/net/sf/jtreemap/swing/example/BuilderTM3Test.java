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

import net.sf.jtreemap.swing.JXTreeMap;
import net.sf.jtreemap.swing.TreeMapNode;
import org.junit.Test;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class BuilderTM3Test {

    @Test
    public void testGetNumberFields() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(BuilderTM3Test.class.getResourceAsStream("/roads.tm3")));
        BuilderTM3 builder = new BuilderTM3(reader);
        assertThat(builder.getNumberFields(), arrayContaining("Length (Miles)", "Repairs per week", "Speed Limit", "Traffic Lights"));
    }

    @Test
    public void testTree() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(BuilderTM3Test.class.getResourceAsStream("/roads.tm3")));
        BuilderTM3 builder = new BuilderTM3(reader);
        assertThat(builder.getRoot().getChildren().size(), is(3));
        assertThat(builder.getRoot().getChildren().get(0).getLabel(), is("Highway"));
        assertThat(builder.getRoot().getChildren().get(1).getLabel(), is("Interstate"));
        assertThat(builder.getRoot().getChildren().get(2).getLabel(), is("Street"));

        assertThat(builder.getRoot().getChildren().get(0).getChildren().size(), is(2));
        assertThat(builder.getRoot().getChildren().get(0).getChildren().get(0).getLabel(), is("Route 1"));
        assertThat(builder.getRoot().getChildren().get(0).getChildren().get(1).getLabel(), is("Route 5"));
    }

}
