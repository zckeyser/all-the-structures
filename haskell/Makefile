CABAL ?= cabal
GHC ?= ghc

.PHONY : all
all : cabal.sandbox.config
	$(CABAL) install --disable-documentation
	cp .cabal-sandbox/bin/test* .

cabal.sandbox.config :
	$(CABAL) v1-update
	$(CABAL) v1-sandbox init
	$(CABAL) v1-install --dependencies-only

.PHONY : clean
clean :
	$(CABAL) clean
	rm -f test.exe

.PHONY : distclean
distclean : clean
	rm -rf cabal.sandbox.config .cabal-sandbox

.PHONY : run-tests
test : all
	./test
