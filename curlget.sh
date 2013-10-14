#!/bin/bash
echo "bad: "
curl -i   http://localhost:8080/password_app/password/validate?password="booger"
echo "aAx1a: "
curl -i  http://localhost:8080/password_app/password/validate?password="aAx1a"
echo ""
echo "aAx1a: "
curl -i  http://localhost:8080/password_app/password/validate?password=aAx1a
echo ""
