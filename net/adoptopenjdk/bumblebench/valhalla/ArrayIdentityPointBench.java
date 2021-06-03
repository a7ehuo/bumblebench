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

public final class ArrayIdentityPointBench extends MicroBench {
   public int numOfIdentityElem = 1001;
	private long _sum;

   public final IdentityPoint[] identityArray = createIdentityArray();

   public IdentityPoint[] createIdentityArray() {
      IdentityPoint[] identityArray = new IdentityPoint[numOfIdentityElem];

      for (int i=0; i < numOfIdentityElem; i++) {
         identityArray[i] = new IdentityPoint(i,i+1);
      }
      return identityArray;
   }

   public int sum(Point[] arr) {
      int sum = 0;

      for (int i=0; i < arr.length; i++) {
         sum += arr[i].getX() + arr[i].getY();
         }

      return sum;
   }

	@Override
   protected long doBatch(long numIterations) throws InterruptedException {
		for (long i = 0; i < numIterations; i+=1) {
			_sum = 0;
         _sum += sum(identityArray);
		}

      return numIterations;
	}
}
