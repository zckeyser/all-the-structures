package dict

import (
  "errors";
  "fmt"
)

// dictionary implemented using a linear probing strategy
type LinearDict struct {
  // keeps track of the number of elements so we know when to expand
  size int
  buckets []*KeyValuePair
}

func NewLinearDict(initialSize int) *LinearDict {
  out := new(LinearDict)

  out.size = 0
  out.buckets = make([]*KeyValuePair, initialSize)

  return out
}

func (d *LinearDict) Set(key string, value int) {
  // check if we need to expand
  if d.saturation() > saturationLimit { d.expand() }

  index := Hash(key) % len(d.buckets)
  pair := new(KeyValuePair)
  pair.key = key
  pair.value = value

  if d.buckets[index] == nil {
    // empty bucket at hashed index -- just set it
    d.buckets[index] = pair
    d.size++
  } else {
    // find the next open bucket
    for i := index + 1; i != index; i++ {
      // roll back to the beginning
      if i >= len(d.buckets) { i = 0 }

      if d.buckets[i] == nil {
        // found an empty bucket
        d.buckets[i] = pair
        d.size++
        return
      } else if d.buckets[i].key == key {
        // this key already exists -- update its value
        d.buckets[i].value = value
        return
      }
    }
  }
}

func (d *LinearDict) Get(key string) (int, error) {
  index, err := d.getIndex(key)

  if err == nil {
    return d.buckets[index].value, nil
  } else {
    return -1, err
  }
}

func (d *LinearDict) getIndex(key string) (int, error) {
  index := Hash(key) % len(d.buckets)

  if d.buckets[index] == nil {
    // we don't have this key
    return -1, errors.New(fmt.Sprintf("key %s not found", key))
  } else {
    // check if the bucket at the hash is the right one
    if d.buckets[index].key == key { return index, nil }

    // check to see if it's in a rollover bucket
    for i := index + 1; i != index; i++ {
      if i == len(d.buckets) { i = 0 }

      if d.buckets[i] == nil {
        // we don't have this key
        return -1, errors.New(fmt.Sprintf("key %s not found", key))
      } else if d.buckets[i].key == key {
        return i, nil
      }
    }
  }

  return -1, errors.New(fmt.Sprintf("key %s not found", key))
}

// returns the current saturation level of the dictionary
func (d *LinearDict) saturation() float32 {
  return float32(d.size) / float32(len(d.buckets))
}

// doubles the capacity of the dictionary to reduce saturation
func (d *LinearDict) expand() {
  oldBuckets := d.buckets

  // increase bucket count
  d.buckets = make([]*KeyValuePair, len(d.buckets) * 2)
  d.size = 0

  // re-insert all the old key/value pairs
  for i := 0; i < len(oldBuckets); i++ {
    if oldBuckets[i] != nil {
      d.Set(oldBuckets[i].key, oldBuckets[i].value)
    }
  }
}
