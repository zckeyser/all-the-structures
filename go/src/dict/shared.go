package dict

var saturationLimit float32 = .6

// dictionary implemented using linear rollover to handle conflicts
type KeyValuePair struct {
  key string
  value int
}
