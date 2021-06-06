/*******************************************************************************
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*******************************************************************************/

package net.adoptopenjdk.bumblebench.valhalla;

import net.adoptopenjdk.bumblebench.core.MicroBench;
import java.util.Random;

public final class ArrayIdentityBench extends MicroBench{
   private static int NUM_ARRAY = 10;
   private static int ARRAY_LENGTH = 10;
   private static Object[][] data;
   Random random = newRandom();

   static {
      data = new Object[NUM_ARRAY][ARRAY_LENGTH];

      for (int i=0; i < NUM_ARRAY; i++) {
         data[i] = new Object[ARRAY_LENGTH];
         for (int j=0; j < data[i].length; j++) {
            data[i][j] = new Object();
	      }
      }
   }

   @Override
   protected long doBatch(long numIterations) throws InterruptedException {
      int index1 = 0;
      int index2 = 0;
      int index3 = 0;

      for (long loop = 0; loop < numIterations; loop++) {
         index1 = random.nextInt((int)(loop + 1)) % NUM_ARRAY;
         index2 = random.nextInt((int)(loop + 1)) % NUM_ARRAY;
         index3 = random.nextInt((int)(loop + 1)) % ARRAY_LENGTH;

         data[index1][index3] = data[index2][index3];
         }
      return numIterations;
   }
}
