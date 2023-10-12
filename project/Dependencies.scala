import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"         %% "webdriver-factory" % "0.46.0"  % Test,
    "org.scalatest"       %% "scalatest"         % "3.2.17"  % Test,
    "org.scalatestplus"   %% "selenium-3-141"    % "3.2.0.0" % Test,
    "com.vladsch.flexmark" % "flexmark-all"      % "0.64.8"  % Test,
    "io.cucumber"         %% "cucumber-scala"    % "8.16.0"  % Test,
    "io.cucumber"          % "cucumber-junit"    % "7.13.0"  % Test,
    "junit"                % "junit"             % "4.13.2"  % Test,
    "com.novocode"         % "junit-interface"   % "0.11"    % Test,
    "com.typesafe"         % "config"            % "1.4.2"   % Test
  )

}
