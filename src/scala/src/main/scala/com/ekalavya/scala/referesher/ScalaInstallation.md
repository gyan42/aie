Scala Installation and Setup:

MAC :
    1) Using Homebrew

 Step 1 : Get Homebrew
Homebrew makes your life a lot easier when it comes to installing applications and languages on a Mac OS.
open your terminal and type:
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
Step 2 : Use Homebrew to install Java
Scala is dependent on Java, you may or may not need to install it. The easiest way to install it is to just use HomeBrew:
Installing Java8
brew cask install java8
Step 3 : Use Homebrew to install Scala
Now with Homebrew installed go to your terminal and type:
brew install scala
Step 4: Add scala/bin folder to your PATH
export PATH=/usr/local/scala/bin:$PATH

If everything was setup correctly you should see this on your screen
    2)  Manual
     Step 1 : Download scala-X.XX.tgz from the official site.
     Step 2: Unzip archive and move it to /usr/local folder
		          sudo cp -R scala-X.XX /usr/local/scala

     Step 3: Open your .bash_profile file 
           Step 4: Add scala/bin folder to your PATH
export PATH=/usr/local/scala/bin:$PATH
typing scala in console.
If everything was setup correctly you should see this on your screen


	Unix:
Step 1: 
Verify the JDK installation on your machine. Open the shell/terminal and type java -version and javac –version

Step 2:
Download Scala Binaries from http://www.scala-lang.org/download/ and then unzip the scala-2.xx.x.tgz file using the following command
	         
	        Step 3: 
		      $ tar -xvzf scala-2.xx.x.tgz
		      export PATH = $PATH:/path/to/scala/bin

	Windows: 
		Step 1: 
Verify the JDK installation on your machine. Open the shell/terminal and type java -version and javac -version
Step 2: 
Download Scala 2.xx.x binaries in the system from  http://www.scala-lang.org/download/ and then run the downloaded file
Step 3:
 Click on next button and follow instructions and complete the setup
Step 4: 
Set path

Right click on My Computer ->Properties ->Advanced System setting ->Environment Variable ->Select Path->Edit

Add path to scala till the bin at the end of the path
by ‘C:\Windows\System32; C:\Program Files\scala\bin’.

Then type scala in command line mode

Install Jupyter Notebook:

Follow the instructions as suggested in the below link
		https://jupyter.org/install
		https://jupyter.readthedocs.io/en/latest/install.html




Install Scala Kernal for Jupyter Notebook:

	Step 1:  Create a launcher
		Adjust ALMOND_VERSION and SCALA_VERSION at your convenience to meet 		your needs. Not all combinations are guaranteed to be available. 
		Click Here for version compatibility.

MAC & Unix:
Set the desired version of Scala and Almond as environment variables:
$ SCALA_VERSION=2.12.8 ALMOND_VERSION=0.4.0

Windows:
> set SCALA_VERSION=2.12.8
> set ALMOND_VERSION=0.4.0
Step 2: Create a launcher via coursier

	MAC & Unix:
curl -Lo coursier https://git.io/coursier-cli
chmod +x coursier
./coursier bootstrap \
    -r jitpack \
    -i user -I user:sh.almond:scala-kernel-api_$SCALA_VERSION:$ALMOND_VERSION \
    sh.almond:scala-kernel_$SCALA_VERSION:$ALMOND_VERSION \
    -o almond

Windows:
> bitsadmin /transfer downloadCoursierCli https://git.io/coursier-cli "%cd%\coursier"
> bitsadmin /transfer downloadCoursierBat https://git.io/coursier-bat "%cd%\coursier.bat"
> .\coursier bootstrap ^
-r jitpack ^
-i user -I user:sh.almond:scala-kernel-api_%SCALA_VERSION%:%ALMOND_VERSION% ^
sh.almond:scala-kernel_%SCALA_VERSION%:%ALMOND_VERSION% ^ -o almond > .\almond –install




Step 3: Install the almond kernel
Run the launcher to install the almond kernel
MAC &Unix:
$ ./almond –install

Windows:
$ .\almond --install
	Step 4: Testing the notebook
Open the Jupyter Notebook and set the kernal as scala
write the below code and check
val x = 2
	val y = 3
x+y



	