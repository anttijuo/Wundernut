FROM clojure

RUN mkdir -p /app

WORKDIR /app

COPY project.clj /app/

COPY ./plugins /tmp/plugins

RUN cp -r /tmp/plugins/* ~/.lein/ &&  rm -rf /tmp/plugins

RUN lein deps

COPY . /app

CMD ["bash"]
