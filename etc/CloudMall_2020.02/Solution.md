_根据个人喜好选择语言新建文件解决下面的问题_
## 1. Split numbers 
Given an array of ints, for example `[6, 4, -3, 0, 5, -2, -1, 0, 1, -9]`, implement in one of the following languages
to move all positive integers to the left, all negative integers to the right, and all zeros to the middle.

You are not allowed to consume extra O(n) storage space, aka. your algorithm space complexity should be O(1).

Your answer should be compilable and runnable, in one of the following function signatures:

* Golang:
```
func CloudmallInterview1(numbers []int) []int
```
* Python3:
```
from typing import Sequence
def cloudmall_interview1(numbers: Sequence[int]) -> Sequence[int]:
```
* Javascript:
```
/**
 * @param {number[]} numbers
 * @returns {number[]}
 */
const cloudmallInterview1 = numbers => {
  // To implement
}
```
* Java:
```
public static int[] CloudmallInterview1(int[] Numbers) {
  if (Numbers == null || Numbers.length < 1) {
    return Numbers;
  }

  quickSort(Numbers, 0, Numbers.length - 1);
  return Numbers;
}

public static void quickSort(int[] Numbers, int start, int end) {
  if (start >= end) {
    return;
  }

  int left = start;
  int right = end;
  int pivot = Numbers[start + (end - start) / 2];

  while (left <= right) {
    while (left <= right && Numbers[left] > pivot) {
      left++;
    }
    while (left <= right && Numbers[right] < pivot) {
      right--;
    }
    if (left <= right) {
      int temp = Numbers[left];
      Numbers[left] = Numbers[right];
      Numbers[right] = temp;
      left++;
      right--;
    }

    quickSort(Numbers, start, right);
    quickSort(Numbers, left, end);
  }
}
```
## 2. Serialize reversed list

Given a “reversed list”, whose first tuple value is the id of string type, and second tuple value is the path to locate the id in a structured document. 

For example, `{"1": "bar", "2": "foo.bar", "3": "foo.foo", "4": "baz.cloudmall.com", "5": "baz.cloudmall.ai"}`
Your mission is to transform the list back to a document in JSON format.

For example, a legit JSON for the above list would be:
```
{
  "bar": "1",
  "foo": {
    "bar": "2",
    "foo": "3"
  },
  "baz": {
    "cloudmall": {
      "com": "4",
      "ai": "5"
    }
  }
}
```
Your answer should be compilable and runnable, in one of the following function signatures:

* Golang:
```
func CloudmallInterview2(revList map[string]string) (jsonStr string, err error)
```
* Python3:
```
from typing import Dict
def cloudmall_interview2(revList: Dict[str, str]) -> str:
```
* Javascript:
```
/**
 * @param {Object.<string, string>} revList
 * @returns {string}
 */
const cloudmallInterview2 = revList => {
  // To implement
}
```
* Java:
```
public static String CloudmallInterview2(Map<String, String> RevList) {
        Node root = new Node("root", null);
        for(Map.Entry<String, String> entry : RevList.entrySet()) {
            root.addNode(entry.getValue(), entry.getKey());
        }

        StringBuilder result = new StringBuilder();
        result.append("{");
        for (Map.Entry<String, Node> entry : root.children.entrySet()) {
            result.append(entry.getValue());
            result.append(",");
        }
        result.deleteCharAt(result.length() - 1);
        result.append("}");
        return result.toString();
}

class Node {
    String key;
    String value;
    LinkedHashMap<String, Node> children;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.children = new LinkedHashMap<>();
    }

    public void addNode(String key, String value) {
        int index = key.indexOf(".");
        if (index < 0) {
            this.children.put(key, new Node(key, value));
            return;
        }

        String key1 = key.substring(0, index);
        String key2 = key.substring(index + 1);
        Node child = this.children.get(key1);
        if (child == null) {
            Node node = new Node(key1, null);
            node.addNode(key2, value);
            this.children.put(key1, node);
            return;
        }

        child.addNode(key2, value);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if (value != null) {
            result.append(key).append(":").append(value);
        } else {
            result.append(key).append(":").append("{");
            for (Map.Entry<String, Node> entry : children.entrySet()) {
                result.append(entry.getValue());
                result.append(",");
            }
            result.deleteCharAt(result.length() - 1);
            result.append("}");
        }
        return result.toString();
    }
}
```
