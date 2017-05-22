package dict

import "hash/fnv"

func Hash(s string) int {
  h := fnv.New32a()
  h.Write([]byte(s))
  return int(h.Sum32())
}
