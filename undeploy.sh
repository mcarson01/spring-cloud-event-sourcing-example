#!/usr/bin/env bash
# Deploys the online store application to CF
set -x

echo '
   ____ _                 _   _   _       _   _
  / ___| | ___  _   _  __| | | \ | | __ _| |_(_)_   _____
 | |   | |/ _ \| | | |/ _` | |  \| |/ _` | __| \ \ / / _ \
 | |___| | (_) | |_| | (_| | | |\  | (_| | |_| |\ V /  __/
  \____|_|\___/ \__,_|\__,_| |_| \_|\__,_|\__|_| \_/ \___|
   ___        _    __ _ _   _
  / _ \ _   _| |_ / _(_) |_| |_ ___ _ __ ___
 | | | | | | | __| |_| | __| __/ _ \ ''__/ __|
 | |_| | |_| | |_|  _| | |_| ||  __/ |  \__ \
  \___/ \__,_|\__|_| |_|\__|\__\___|_|  |___/

'

cf delete account-service -r -f
cf delete catalog-service -r -f
cf delete config-service -r -f
cf delete discovery-service -r -f
cf delete edge-service -r -f
cf delete hystrix-dashboard -r -f
cf delete inventory-service -r -f
cf delete online-store-web -r -f
cf delete order-service -r -f
cf delete user-service -r -f
cf delete shopping-cart-service -r -f
cf delete zipkin-tracing -r -f

cf delete-service user-service -f
cf delete-service edge-service -f
cf delete-service discovery-service -f
cf delete-service config-service -f

