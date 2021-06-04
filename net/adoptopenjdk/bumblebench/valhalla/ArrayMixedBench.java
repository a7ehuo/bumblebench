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

public final class ArrayMixedBench extends MicroBench{
   private static int NUM_ARRAY = 10;
   private static int ARRAY_LENGTH = 2;
   private static int PRIMITIVE_ARRAY_INDEX = NUM_ARRAY - 1;
   private static Object[][] data;
   Random random = newRandom();

   static {
      data = new Object[NUM_ARRAY][ARRAY_LENGTH];

      for (int i=0; i < PRIMITIVE_ARRAY_INDEX; i++) {
         data[i] = new Object[ARRAY_LENGTH];
         for (int j=0; j < data[i].length; j++) {
            data[i][j] = new Object();
	      }
      }

      data[PRIMITIVE_ARRAY_INDEX] = new PrimitiveClass[ARRAY_LENGTH];
      for (int j=0; j < data[PRIMITIVE_ARRAY_INDEX].length; j++) {
         data[PRIMITIVE_ARRAY_INDEX][j] = new PrimitiveClass();
      }
   }

   @Override
   protected long doBatch(long numIterations) throws InterruptedException {
     long numIterForIdentity = (new Double(numIterations * 0.9999)).longValue();
     // make sure the primitive array is picked at least once in each batch
     numIterForIdentity = (numIterForIdentity >= numIterations) ? (numIterations - 1) : numIterForIdentity;

     for (long loop = 0; loop < numIterations; loop++) {
        int index = (int)((loop < numIterForIdentity) ? (random.nextInt(loop) % PRIMITIVE_ARRAY_INDEX) : PRIMITIVE_ARRAY_INDEX);
        int length = data[index].length;

        for (int j=0; j<length/2; j++) {
            data[index][j] = data[index][length-j-1];
	      }
		}

   return numIterations;
	}
}
