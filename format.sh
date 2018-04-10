#!/bin/sh
boot -d boot-fmt fmt --git --mode overwrite --really --options '{:style :community :list {:constant-pair? true} :vector {:wrap-coll? nil} :map {:force-nl? true :comma? nil}}'
