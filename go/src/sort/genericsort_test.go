package mysort

import "testing"
import "strings"

func (n int) Less(other interface{}) bool {
  switch t := other.(type) {
  default:
    return false
  case int:
    return n < t
  }
}

func (s string) Less(other interface{}) bool {
  switch t := other.(type) {
  default:
    return false
  case string:
    return strings.Compare(s, t) < 0
  }
}

type person struct {
  name string
  age int
}

func Less(p person) (other interface{}) bool {
  switch t := other.(type) {
  default:
    return false
  case person:
    return p.age < t.age || strings.Compare(p.name, t.name) < 0
  }
}

func IntSortTesting(t *testing.T) {

}

func StringSortTesting(t *testing.T) {

}

func InterfaceSortTesting(t *testing.T) {

}
