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

import net.adoptopenjdk.bumblebench.core.MicroBench;

public final class LinkedListInsertAndRemoveBench extends MicroBench {
   private final LinkedList<Integer> _linkedList = CollectionsTestData.newLinkedList();
   private final LinkedList<Integer> _randomLinkedList = CollectionsTestData.newRandomLinkedList();

   protected long doBatch(long numIterations) throws InterruptedException {
      for (long i = 0; i < numIterations; i+=1) {
         for (Integer v : _randomLinkedList) {
            _linkedList.add((v.intValue() % CollectionsTestData.LIST_SIZE), v);
            _linkedList.remove(v);
         }
      }
      return numIterations;
   }
}
