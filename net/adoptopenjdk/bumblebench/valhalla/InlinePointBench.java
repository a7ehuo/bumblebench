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

public final class InlinePointBench extends MicroBench {

   protected long doBatch(long numIterations) throws InterruptedException {
      long result = 0;
      for (long i = 0; i < numIterations; i++) {
         InlinePoint p = new InlinePoint((int)i, (int)(i+1)); 
         result += p.x * p.y; 
      }
      return numIterations;
   }
}
