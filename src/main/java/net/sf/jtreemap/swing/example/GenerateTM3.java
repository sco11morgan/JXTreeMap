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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Random;

public class GenerateTM3 {

    public GenerateTM3() {
        String[] countries = new String[]{"AU", "JP", "UK", "US"};
        String[] marketCapName = new String[]{"Large", "Mid", "Small"};
        String[] sectors = new String[]{"Tech", "Finance", "Consumers", "Autos"};
        NumberFormat numberFormat = new DecimalFormat("##.00");

        Random random = new Random(System.currentTimeMillis());


        StringBuilder sb = new StringBuilder();
        sb.append("Market Cap");
        sb.append('\t');
        sb.append("Shares");
        sb.append('\n');

        sb.append("FLOAT");
        sb.append('\t');
        sb.append("INTEGER");
        sb.append('\n');

        for (int x=1; x<=20000; x++){
            double marketCap = Math.abs(random.nextDouble() * 10000000);
            sb.append(numberFormat.format(marketCap));
            sb.append('\t');
            sb.append(Math.abs(random.nextInt()%10000000));
            sb.append('\t');
            sb.append("Top");
            sb.append('\t');
            sb.append(countries[Math.abs(random.nextInt())%4]);
            sb.append('\t');
            sb.append(marketCapName[Math.abs(random.nextInt())%3]);
            sb.append('\t');
            sb.append(sectors[Math.abs(random.nextInt())%4]);
            sb.append('\t');
            sb.append("Company " + x);
            sb.append('\n');
        }

        System.out.println(sb);


    }

    public static void main(String[] args) {
        new GenerateTM3();
    }
}
