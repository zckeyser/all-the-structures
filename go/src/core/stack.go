package core

import "errors"

type Stack struct {
  data []int
}

func (s *Stack) Push(item int) {
  s.data = append([]int{item}, s.data...)
}

func (s *Stack) Pop() (int, error) {
  if len(s.data) == 0 { return -1, errors.New("attempted to pop from empty stack") }

  retval := s.data[0]
  s.data = s.data[1:]

  return retval, nil
}

func (s *Stack) Size() int {
  return len(s.data)
}
