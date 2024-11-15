apt-get -y install software-properties-common
apt-get update
#sh -c "wget -O - https://dl.openfoam.org/gpg.key > /etc/apt/trusted.gpg.d/openfoam.asc"
add-apt-repository http://dl.openfoam.org/ubuntu
add-apt-repository "http://dl.openfoam.org/ubuntu dev"
apt-get update
echo aaaaaa
apt-get -y install openfoam-dev
#apt-get -y install openfoam11
cd ~/
STRING="source /opt/openfoam11/etc/bashrc"
FILE=".bashrc"
#grep -q -F "$STRING" "$FILE" && sed -i -e '$asource /opt/openfoam11/etc/bashrc' .bashrc || echo 'bububu'

if grep -q -F "$STRING" "$FILE"; then
  echo 'Found';
else
  sed -i -e '$asource /opt/openfoam11/etc/bashrc' .bashrc;
fi

apt-get update
cat $USER
cat $FOAM_RUN
#mkdir -p $FOAM_RUN
#cd $FOAM_RUN
#cp -r $FOAM_TUTORIALS/incompressibleFluid/pitzDailySteady .
#cd pitzDailySteady
#blockMesh
#paraFoam -block