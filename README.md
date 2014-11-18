# clj-vis

Clojure data with HTML visualization baked in! This library intends to extend the concept that Clojure embodies so well, that being code as data and data as code. Taking that one step further, what if data could not only be code, but also maintain its own visual representation? `clj-vis` attempts to resolve that problem by creating a simple framework for data to also package `html` and other visual representation information within itself. In this way downstream consumers of your data elements only need understand your *visual representation* and leave the actual rendering to the framework.

Fundamentally `clj-vis` attempts to **decouple the visualization** of data from each downstream consumer and **bake it into the data itself**.

## Key Features

* Clojure data with **visualization information included**
* **Serialization support**
* **Minimal integration** to current projects

## Installation

**THIS WON'T WORK UNTIL THIS BANNER IS REMOVED**

To jump in and get started simply add:

* `[clj-vis "0.1.0"]` to your project.clj file
* `(:require [clj-vis.core :refer [<vis >vis]])` to your project namespace

## Usage

FIXME: explanation

## License

Copyright © 2014

Released under the [MIT license](http://opensource.org/licenses/MIT).
