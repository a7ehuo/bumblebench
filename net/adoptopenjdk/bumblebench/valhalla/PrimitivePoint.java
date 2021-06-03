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

primitive public class PrimitivePoint implements Point {
   public final int x;
   public final int y;

   PrimitivePoint() {
      this.x=0;
      this.y=0;
   }

   PrimitivePoint(int val1, int val2) {
      this.x = val1;
      this.y = val2;
   }

   @Override
   public int getX() { return x; }
   public int getY() { return y; }
}
