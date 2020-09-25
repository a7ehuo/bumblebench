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

import java.util.LinkedList;
import java.util.Random;

public class CollectionsTestData {
   public final static int LIST_SIZE = 100;

   public static LinkedList<Integer> newLinkedList() {
      LinkedList<Integer> result = new LinkedList<Integer>();
      for(int i = 0; i < LIST_SIZE; i++){
         result.add(new Integer(i));
      }
      return result;
   }

   public static LinkedList<Integer> newRandomLinkedList() {
      LinkedList<Integer> result = new LinkedList<Integer>();
      Random rand = new Random(43438932);
      int randomBound = LIST_SIZE * 2;

      for(int i = 0; i < LIST_SIZE; i++){
         result.add(new Integer(rand.nextInt(randomBound)));
      }
      return result;
   }
}
