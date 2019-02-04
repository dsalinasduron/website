declare -a array
array=( $(find ~/westminsterTeaching/fall2018/cmpt202 -iname "$1") )
let counter=0
for i in ${array[@]}; do
	echo "$counter: $i"
	let counter=counter+1
done
read -p "select: " choice
if [[ $choice -ge 0 ]]; then
	cp -r ${array[$choice]} .
fi
