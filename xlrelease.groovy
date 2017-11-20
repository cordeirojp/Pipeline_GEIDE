// Exported from:        http://jean-X202E:5516/#/templates/Folder198142445-Release14220270/releasefile
// XL Release version:   7.2.0
// Date created:         Mon Nov 20 12:00:02 CET 2017

def server(type, title) {
    def cis = configurationApi.searchByTypeAndTitle(type, title)
    if (cis.isEmpty()) {
        throw new RuntimeException("No CI found for the type '${type}' and title '${title}'")
    }
    if (cis.size() > 1) {
        throw new RuntimeException("More than one CI found for the type '${type}' and title '${title}'")
    }
    cis.get(0)
}
def host1 = server('host.Unix','ansibleServer')
def jenkinsServer1 = server('jenkins.Server','JenkinsServer')
def jenkinsServer2 = server('jenkins.Server','JenkinsServer')
xlr {
  release('GEIDE_SCM') {
    description 'Pipeline GEIDE_SCM'
    scheduledStartDate Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", '2017-11-16T09:00:00+0100')
    phases {
      phase('PLANIFIER') {
        color '#dd4b39'
        tasks {
          manual('P1') {
            team 'Release Admin'
          }
          manual('P2') {
            plannedDuration 3300
            team 'Release Admin'
          }
          custom('Ansible') {
            script {
              type 'ansible.RunPlaybook'
              host host1
              playbook '---\n' +
                       '- hosts: 127.0.0.1\n' +
                       '  remote_user: jean\n' +
                       '  tasks:\n' +
                       '    - name: test connection\n' +
                       '      ping:\n' +
                       '    - name: test connection\n' +
                       '      shell: uptime\n' +
                       '      register: up\n' +
                       '    - debug: var=up.stdout_lines'
            }
          }
        }
      }

      phase('BUILDER') {
        color '#ff9e3b'
        tasks {
          custom('Jenkins1') {
            team 'Release Admin'
            script {
              type 'jenkins.Build'
              jenkinsServer jenkinsServer1
              jobName 'Pipeline_GEIDE'
            }
          }
          custom('Jenkins2') {
            team 'Release Admin'
            script {
              type 'jenkins.Build'
              jenkinsServer jenkinsServer2
              jobName 'myPipeline'
            }
          }
        }
      }

    }
  }
}
