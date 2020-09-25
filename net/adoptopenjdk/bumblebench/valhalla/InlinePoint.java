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

inline public final class InlinePoint {
   public final int x;
   public final int y;
   
   public InlinePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

   public static InlinePoint withX(InlinePoint p, int x) {
      InlinePoint p1 = __WithField(p.x, x);
      return p1;
   }
}
