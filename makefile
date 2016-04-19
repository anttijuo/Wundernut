mkfile_path := $(abspath $(lastword $(MAKEFILE_LIST)))
project_name := $(notdir $(patsubst %/,%,$(dir $(mkfile_path))))
rwildcard=$(wildcard $1$2) $(foreach d,$(wildcard $1*),$(call rwildcard,$d/,$2))

prod_sources=project.clj $(call rwildcard,src/,*.clj)


run : prod-image 
	docker run -it -p 80 $(project_name) > .prod_container

host : container := $(shell cat .prod_container)
host : port = $(shell docker inspect --format '{{(index (index .NetworkSettings.Ports "80/tcp") 0).HostPort}}' $(container))
host : ip = $(shell docker-machine ip default)

host:
	@echo $(ip):$(port)

stop : container := $(shell cat .prod_container)

stop:
	docker stop $(container)

restart : container := $(shell cat .prod_container)

restart: 
	docker restart $(container)

remove : container := $(shell cat .prod_container)

remove: 
	docker rm $(container)
	rm .prod_container


target/standalone.jar : $(prod_sources) project-image
	docker run --rm -it -v $(CURDIR):/app -w /app $(project_name)-dev lein uberjar
	mv target/uberjar/$(project_name)-$(shell docker run -it -v $(CURDIR):/app -w /app  $(project_name)-dev lein exec -e '(println (nth (clojure.edn/read-string (slurp "project.clj")) 2))')-standalone.jar target/standalone.jar

prod-image : target/standalone.jar
	docker build -t $(project_name) --file Prod .
	touch prod-image

new : project.clj

project.clj : 
	docker run -it -v $(CURDIR):/$(project_name) -w /$(project_name) clojure lein new app com.siili/$(project_name) --to-dir . --force
	echo '##make events'  >> .gitignore
	echo project-image >> .gitignore
	echo prod-image >> .gitignore
	echo .prod_container >> .gitignore

project-image : project.clj
	docker build -t $(project_name)-dev .
	touch project-image

project-shell : project-image 
	docker run -it -v $(CURDIR):/app -w /app  $(project_name)-dev

project-repl : project-image
	docker run -it -v $(CURDIR):/app -w /app  $(project_name)-dev lein repl

.PHONY: project-shell project-repl new remove stop restart
