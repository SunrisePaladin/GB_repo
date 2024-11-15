FROM ubuntu:22.04
COPY ./entry.sh /base_entry/entry.sh
RUN apt-get update
CMD ["add-apt-repository" " http://dl.openfoam.org/ubuntu"]
CMD ["add-apt-repository" "http://dl.openfoam.org/ubuntu dev"]


#добавить копирование туториала
#COPY $FOAM_TUTORIALS/incompressibleFluid/pitzDailySteady /base_entry
#CMD ["cp" "-r" "$FOAM_TUTORIALS/incompressibleFluid/pitzDailySteady" "/base_entry/tutorials"]
CMD ["pwd"]
ENTRYPOINT ["bash", "base_entry/entry.sh"]