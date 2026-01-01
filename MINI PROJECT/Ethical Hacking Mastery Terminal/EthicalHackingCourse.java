import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

// ANSI Color Codes in same file
class Colors {
    // Reset
    public static final String RESET = "\u001B[0m";

    // Regular Colors
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Bold Colors
    public static final String BOLD_BLACK = "\u001B[1;30m";
    public static final String BOLD_RED = "\u001B[1;31m";
    public static final String BOLD_GREEN = "\u001B[1;32m";
    public static final String BOLD_YELLOW = "\u001B[1;33m";
    public static final String BOLD_BLUE = "\u001B[1;34m";
    public static final String BOLD_MAGENTA = "\u001B[1;35m";
    public static final String BOLD_CYAN = "\u001B[1;36m";
    public static final String BOLD_WHITE = "\u001B[1;37m";

    // Background Colors
    public static final String BG_BLACK = "\u001B[40m";
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_MAGENTA = "\u001B[45m";
    public static final String BG_CYAN = "\u001B[46m";
    public static final String BG_WHITE = "\u001B[47m";

    // Special
    public static final String BLINK = "\u001B[5m";
    public static final String REVERSE = "\u001B[7m";
    public static final String UNDERLINE = "\u001B[4m";
}

// Main program
public class EthicalHackingCourse {
    private int currentModule = 0;
    private List<Integer> completedModules = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    private void clearScreen() {
        try {
            String os = System.getProperty("os.name");
            if (os.toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    private void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    private void typewriterEffect(String text, int delay, String color) {
        for (char c : text.toCharArray()) {
            System.out.print(color + c + Colors.RESET);
            System.out.flush();
            sleep(delay);
        }
        System.out.println();
    }

    private void animatedBanner() {
        clearScreen();

        String[] colors = {Colors.GREEN, Colors.CYAN, Colors.BLUE, Colors.MAGENTA};
        char[] matrixChars = {'0', '1', ' ', '█', '▓', '▒'};

        for (int i = 0; i < 3; i++) {
            for (String color : colors) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < 70; j++) {
                    line.append(matrixChars[random.nextInt(matrixChars.length)]);
                }
                System.out.print("\r" + color + line + Colors.RESET);
                System.out.flush();
                sleep(50);
            }
        }
        System.out.println("\n");

        String[] bannerLines = {
            "╔══════════════════════════════════════════════════════════════════╗",
            "║        ETHICAL HACKING MASTERY - INTERACTIVE TERMINAL            ║",
            "║                  From Basics to Advanced                         ║",
            "║          ⚠️  FOR EDUCATIONAL PURPOSES ONLY ⚠️                    ║",
            "╚══════════════════════════════════════════════════════════════════╝"
        };

        String[] bannerColors = {
            Colors.BOLD_CYAN,
            Colors.BOLD_YELLOW,
            Colors.BOLD_GREEN,
            Colors.BOLD_RED
        };

        for (int i = 0; i < bannerLines.length; i++) {
            String color = bannerColors[i < bannerColors.length ? i : bannerColors.length - 1];
            System.out.println(color + bannerLines[i] + Colors.RESET);
            sleep(100);
        }

        sleep(200);
        String subtitle = "        🔐 Master the Art of Cybersecurity 🔐";
        typewriterEffect(subtitle, 20, Colors.BOLD_MAGENTA);

        sleep(200);
        System.out.print(Colors.CYAN + "\n[" + Colors.RESET);
        System.out.flush();
        sleep(100);
        System.out.print(Colors.GREEN + "●" + Colors.RESET);
        System.out.flush();
        sleep(100);
        System.out.print(Colors.YELLOW + "●" + Colors.RESET);
        System.out.flush();
        sleep(100);
        System.out.print(Colors.RED + "●" + Colors.RESET);
        System.out.flush();
        sleep(100);

        LocalDateTime now = LocalDateTime.now();
        String dt = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(Colors.CYAN + "] System Ready | Date: " + dt + Colors.RESET);
        System.out.println();
    }

    private void loadingAnimation(String text, int durationSeconds) {
        String[] chars = {"⠋", "⠙", "⠹", "⠸", "⠼", "⠴", "⠦", "⠧", "⠇", "⠏"};
        long end = System.currentTimeMillis() + durationSeconds * 1000L;
        while (System.currentTimeMillis() < end) {
            for (String ch : chars) {
                System.out.print("\r" + Colors.CYAN + ch + " " + text + "..." + Colors.RESET);
                System.out.flush();
                sleep(100);
            }
        }
        System.out.println("\r" + Colors.GREEN + "✓ " + text + " complete!" + Colors.RESET);
    }

    private void progressBar(int current, int total, int barLength) {
        double percent = total == 0 ? 0.0 : (double) current / total;
        int filled = (int) (barLength * percent);
        String bar = "█".repeat(filled) + "░".repeat(barLength - filled);

        String color;
        if (percent < 0.33) color = Colors.RED;
        else if (percent < 0.66) color = Colors.YELLOW;
        else color = Colors.GREEN;

        System.out.print("\r" + color + "Progress: [" + bar + "] " + (int) (percent * 100) + "%" + Colors.RESET);
        System.out.flush();
    }

    private void printSection(String title, String content, String titleColor) {
        System.out.println(titleColor + title + Colors.RESET);
        System.out.println(Colors.CYAN + "-".repeat(title.length()) + Colors.RESET);
        System.out.println(Colors.WHITE + content + Colors.RESET + "\n");
    }

    private void moduleHeader(String moduleNum, String title) {
        clearScreen();
        System.out.println("\n" + Colors.BOLD_CYAN + "=".repeat(70) + Colors.RESET);
        String header = "MODULE " + moduleNum + ": " + title;
        int pad = Math.max(0, (70 - header.length()) / 2);
        System.out.println(Colors.BOLD_YELLOW + " ".repeat(pad) + header + Colors.RESET);
        System.out.println(Colors.BOLD_CYAN + "=".repeat(70) + Colors.RESET + "\n");
        sleep(300);
    }

    private String mainMenu() {
        animatedBanner();

        int totalModules = 21;
        int completed = completedModules.size();
        System.out.println(Colors.BOLD_YELLOW + "📊 Your Learning Progress:" + Colors.RESET);
        progressBar(completed, totalModules, 40);
        System.out.println("\n" + Colors.CYAN + "Completed: " + completed + "/" + totalModules + " modules" + Colors.RESET + "\n");

        System.out.println(Colors.BOLD_CYAN + "=".repeat(70) + Colors.RESET);
        System.out.println(Colors.BOLD_YELLOW + "📚 LEARNING MODULES:" + Colors.RESET + "\n");

        String[][] modules = {
            {"1.  Introduction to Ethical Hacking & Cybersecurity", "🎯"},
            {"2.  Linux Command Line & System Administration", "🐧"},
            {"3.  Networking Fundamentals & Protocols", "🌐"},
            {"4.  Python for Ethical Hackers", "🐍"},
            {"5.  Information Gathering & Reconnaissance", "🔍"},
            {"6.  Scanning & Enumeration (Nmap)", "📡"},
            {"7.  Vulnerability Analysis & Assessment", "🛡️"},
            {"8.  System Hacking & Exploitation (Metasploit)", "💣"},
            {"9.  Web Application Security (OWASP Top 10)", "🌐"},
            {"10. Wireless Network Hacking", "📶"},
            {"11. Social Engineering", "🎭"},
            {"12. Cryptography & Password Cracking", "🔐"},
            {"13. Network Sniffing & MITM Attacks", "🕵️"},
            {"14. Post-Exploitation & Privilege Escalation", "⬆️"},
            {"15. Malware Analysis & Reverse Engineering", "🦠"},
            {"16. Active Directory Penetration Testing", "🏢"},
            {"17. Mobile Application Security", "📱"},
            {"18. Cloud Security Testing", "☁️"},
            {"19. IoT Security & Hardware Hacking", "🔌"},
            {"20. Report Writing & Professional Practice", "📝"},
            {"21. Practical Labs & CTF Challenges", "🏆"},
            {"0.  Exit Program", "🚪"}
        };

        for (String[] module : modules) {
            String moduleNum = module[0].split("\\.")[0].trim();
            if (moduleNum.matches("\\d+") && completedModules.contains(Integer.parseInt(moduleNum))) {
                System.out.println(Colors.GREEN + "✅ " + module[1] + " " + module[0] + Colors.RESET);
            } else if (moduleNum.equals("0")) {
                System.out.println(Colors.RED + module[1] + " " + module[0] + Colors.RESET);
            } else {
                System.out.println(Colors.CYAN + "   " + module[1] + " " + module[0] + Colors.RESET);
            }
        }

        System.out.println("\n" + Colors.BOLD_CYAN + "=".repeat(70) + Colors.RESET);
        System.out.print("\n" + Colors.BOLD_YELLOW + "🎯 Select a module (0-21): " + Colors.RESET);
        return scanner.nextLine().trim();
    }

    private void module01Intro() {
        moduleHeader("1", "INTRODUCTION TO ETHICAL HACKING");

        printSection(
            "📖 WHAT IS ETHICAL HACKING?",
            "Ethical hacking is the authorized practice of bypassing system security\n" +
            "to identify potential data breaches and threats in a network.\n" +
            "The purpose is to find vulnerabilities before malicious hackers do.",
            Colors.BOLD_GREEN
        );

        System.out.println(Colors.BOLD_MAGENTA + "🎯 KEY CONCEPTS:" + Colors.RESET);
        String[][] concepts = {
            {"White Hat Hackers", "Ethical hackers with permission", Colors.GREEN},
            {"Black Hat Hackers", "Malicious hackers", Colors.RED},
            {"Gray Hat Hackers", "Between ethical and malicious", Colors.YELLOW},
            {"Penetration Testing", "Simulated cyber attacks", Colors.CYAN},
            {"Vulnerability Assessment", "Identifying security weaknesses", Colors.BLUE}
        };
        for (int i = 0; i < concepts.length; i++) {
            System.out.println(concepts[i][2] + (i + 1) + ". " + concepts[i][0] + Colors.RESET + ": " + concepts[i][1]);
        }
        System.out.println();

        printSection(
            "⚖️ LEGAL & ETHICAL CONSIDERATIONS",
            "✓ Always get written permission before testing\n" +
            "✓ Follow the scope of engagement\n" +
            "✓ Maintain confidentiality\n" +
            "✓ Report all findings responsibly\n" +
            "✓ Never cause intentional damage",
            Colors.BOLD_RED
        );

        printSection(
            "📋 PHASES OF ETHICAL HACKING",
            "1. Reconnaissance: Information gathering\n" +
            "2. Scanning: Identifying live hosts and open ports\n" +
            "3. Gaining Access: Exploiting vulnerabilities\n" +
            "4. Maintaining Access: Creating backdoors\n" +
            "5. Covering Tracks: Removing evidence\n" +
            "6. Reporting: Documenting findings",
            Colors.BOLD_YELLOW
        );

        printSection(
            "🛠️ RECOMMENDED CERTIFICATIONS",
            "• CEH (Certified Ethical Hacker)\n" +
            "• OSCP (Offensive Security Certified Professional)\n" +
            "• CompTIA Security+\n" +
            "• GPEN (GIAC Penetration Tester)\n" +
            "• eJPT (eLearnSecurity Junior Penetration Tester)",
            Colors.BOLD_BLUE
        );

        printSection(
            "📚 LEARNING RESOURCES",
            "• OWASP.org - Web application security\n" +
            "• HackerOne - Bug bounty platform\n" +
            "• TryHackMe / HackTheBox - Practice platforms\n" +
            "• KrebsOnSecurity - Security news\n" +
            "• Bleeping Computer - Cybersecurity news",
            Colors.BOLD_CYAN
        );

        System.out.println("\n" + Colors.GREEN + "=".repeat(70) + Colors.RESET);
        System.out.print(Colors.BOLD_GREEN + "✅ Press Enter to mark as complete and continue..." + Colors.RESET);
        scanner.nextLine();
        if (!completedModules.contains(1)) completedModules.add(1);
        loadingAnimation("Saving progress", 1);
    }

    private void module02Linux() {
        moduleHeader("2", "LINUX COMMAND LINE & SYSTEM ADMINISTRATION");

        printSection(
            "🐧 WHY LINUX FOR ETHICAL HACKING?",
            "• Most security tools are built for Linux\n" +
            "• Powerful command-line interface\n" +
            "• Open-source and customizable\n" +
            "• Kali Linux - the de facto hacking distribution",
            Colors.BOLD_GREEN
        );

        System.out.println(Colors.BOLD_CYAN + "🔧 ESSENTIAL COMMANDS:" + Colors.RESET + "\n");

        System.out.println(Colors.BOLD_YELLOW + "FILE & DIRECTORY OPERATIONS:" + Colors.RESET);
        String[][] fileCommands = {
            {"ls -la", "List all files with details"},
            {"cd /path", "Change directory"},
            {"pwd", "Print working directory"},
            {"mkdir dir", "Create directory"},
            {"rm -rf dir", "Remove recursively"},
            {"find / -name file", "Search for files"}
        };
        printCommands(fileCommands);

        System.out.println(Colors.BOLD_YELLOW + "SYSTEM INFORMATION:" + Colors.RESET);
        String[][] sysCommands = {
            {"uname -a", "System information"},
            {"whoami", "Current user"},
            {"hostname", "System hostname"},
            {"df -h", "Disk space"},
            {"free -h", "Memory usage"},
            {"top / htop", "Process monitor"}
        };
        printCommands(sysCommands);

        System.out.println(Colors.BOLD_YELLOW + "NETWORKING:" + Colors.RESET);
        String[][] netCommands = {
            {"ifconfig / ip a", "Network interfaces"},
            {"ping host", "Test connectivity"},
            {"netstat -tuln", "Active connections"},
            {"ss -tuln", "Socket statistics"}
        };
        printCommands(netCommands);

        System.out.println(Colors.BOLD_MAGENTA + "💻 BASH SCRIPT EXAMPLE:" + Colors.RESET + "\n");
        String script = "#!/bin/bash\n" +
                       "# Security check script\n\n" +
                       "if [ \"$EUID\" -ne 0 ]; then \n" +
                       "   echo \"Please run as root\"\n" +
                       "   exit 1\n" +
                       "fi\n\n" +
                       "echo \"Checking open ports...\"\n" +
                       "netstat -tuln | grep LISTEN\n\n" +
                       "echo \"Checking failed logins...\"\n" +
                       "grep \"Failed password\" /var/log/auth.log | tail -5";
        System.out.println(Colors.YELLOW + script + Colors.RESET + "\n");

        printSection(
            "🎯 PRACTICE EXERCISES",
            "1. Create pentesting directory structure\n" +
            "2. Write security check scripts\n" +
            "3. Practice grep, awk, sed for log analysis\n" +
            "4. Set up SSH key authentication\n" +
            "5. Learn tmux for terminal multiplexing",
            Colors.BOLD_BLUE
        );

        System.out.println("\n" + Colors.GREEN + "=".repeat(70) + Colors.RESET);
        System.out.print(Colors.BOLD_GREEN + "✅ Press Enter to mark as complete and continue..." + Colors.RESET);
        scanner.nextLine();
        if (!completedModules.contains(2)) completedModules.add(2);
        loadingAnimation("Saving progress", 1);
    }

    private void printCommands(String[][] commands) {
        for (String[] cmd : commands) {
            System.out.printf("  " + Colors.GREEN + "%-20s" + Colors.RESET + " " + Colors.CYAN + "# %s" + Colors.RESET + "%n",
                    cmd[0], cmd[1]);
        }
        System.out.println();
    }

    private void showRemainingModules() {
        clearScreen();
        System.out.println("\n" + Colors.BOLD_CYAN + "=".repeat(70) + Colors.RESET);
        System.out.println(Colors.BOLD_YELLOW + "📚 REMAINING MODULES OVERVIEW" + Colors.RESET);
        System.out.println(Colors.BOLD_CYAN + "=".repeat(70) + Colors.RESET + "\n");

        String[][] modules = {
            {"MODULE 6", "Scanning & Enumeration", "📡", "Nmap mastery, Service detection, OS fingerprinting"},
            {"MODULE 7", "Vulnerability Analysis", "🛡️", "CVE databases, Nessus/OpenVAS, Risk assessment"},
            {"MODULE 8", "System Exploitation", "💣", "Metasploit Framework, Exploit development, Buffer overflows"},
            {"MODULE 9", "Web App Security", "🌐", "OWASP Top 10, SQL Injection, XSS/CSRF"},
            {"MODULE 10", "Wireless Hacking", "📶", "WiFi security, Aircrack-ng, Evil twin"},
            {"MODULE 11", "Social Engineering", "🎭", "Phishing, Pretexting, SET framework"},
            {"MODULE 12", "Cryptography", "🔐", "Hash cracking, John the Ripper, Hashcat"},
            {"MODULE 13", "Network Sniffing", "🕵️", "Wireshark, ARP spoofing, MITM"},
            {"MODULE 14", "Post-Exploitation", "⬆️", "Privilege escalation, Data exfiltration, Persistence"},
            {"MODULE 15", "Malware Analysis", "🦠", "Reverse engineering, IDA Pro/Ghidra, Sandbox"},
            {"MODULE 16", "Active Directory", "🏢", "Kerberoasting, Pass-the-hash, BloodHound"},
            {"MODULE 17", "Mobile Security", "📱", "Android/iOS, APK analysis, Frida"},
            {"MODULE 18", "Cloud Security", "☁️", "AWS/Azure/GCP, S3 buckets, IAM"},
            {"MODULE 19", "IoT & Hardware", "🔌", "Firmware analysis, UART/JTAG, RF attacks"},
            {"MODULE 20", "Report Writing", "📝", "Professional reports, Executive summary, Ethics"},
            {"MODULE 21", "Labs & CTF", "🏆", "TryHackMe, HackTheBox, Bug bounty"}
        };

        for (String[] module : modules) {
            System.out.println(Colors.BOLD_MAGENTA + module[2] + " " + module[0] + ": " + module[1] + Colors.RESET);
            String[] topics = module[3].split(", ");
            for (String topic : topics) {
                System.out.println("  " + Colors.CYAN + "• " + topic + Colors.RESET);
            }
            System.out.println();
        }

        System.out.println(Colors.BOLD_GREEN + "⚡ MASTERY PATH:" + Colors.RESET);
        String[] steps = {
            "1. Complete all 21 modules",
            "2. Practice on HTB/THM",
            "3. Build home lab",
            "4. Get certified (CEH/OSCP)",
            "5. Join bug bounty programs",
            "6. Never stop learning!"
        };
        for (String step : steps) {
            System.out.println(Colors.YELLOW + "  " + step + Colors.RESET);
        }

        System.out.println("\n" + Colors.BOLD_RED + "💡 REMEMBER:" + Colors.RESET);
        System.out.println(Colors.RED + "  • Get written authorization" + Colors.RESET);
        System.out.println(Colors.RED + "  • Use knowledge ethically" + Colors.RESET);
        System.out.println(Colors.RED + "  • Follow laws and regulations" + Colors.RESET);
    }

    private void exitAnimation() {
        clearScreen();
        System.out.println("\n".repeat(3));

        String[][] messages = {
            {"Saving your progress", Colors.CYAN},
            {"Securing session", Colors.YELLOW},
            {"Closing connections", Colors.GREEN}
        };

        for (String[] msg : messages) {
            System.out.print(msg[1] + "[*] " + msg[0] + "..." + Colors.RESET);
            System.out.flush();
            sleep(500);
            System.out.println(" " + Colors.GREEN + "✓" + Colors.RESET);
        }

        System.out.println();
        typewriterEffect("👋 Thank you for using Ethical Hacking Mastery Terminal!", 40, Colors.BOLD_CYAN);
        typewriterEffect("🔒 Remember: Use your skills ethically and legally!", 40, Colors.BOLD_YELLOW);
        System.out.println("\n" + Colors.BOLD_GREEN + "Stay curious. Stay ethical. Stay secure." + Colors.RESET);
        System.out.println();
        sleep(1000);
    }

    private void run() {
        while (true) {
            String choice = mainMenu();
            switch (choice) {
                case "0":
                    exitAnimation();
                    return;
                case "1":
                    module01Intro();
                    break;
                case "2":
                    module02Linux();
                    break;
                case "3": case "4": case "5": case "6": case "7": case "8":
                case "9": case "10": case "11": case "12": case "13":
                case "14": case "15": case "16": case "17": case "18":
                case "19": case "20": case "21":
                    showRemainingModules();
                    System.out.println("\n" + Colors.GREEN + "=".repeat(70) + Colors.RESET);
                    System.out.print(Colors.BOLD_CYAN + "✅ Press Enter to return to main menu..." + Colors.RESET);
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("\n" + Colors.RED + "❌ Invalid choice! Please try again." + Colors.RESET);
                    sleep(1500);
            }
        }
    }

    public static void main(String[] args) {
        EthicalHackingCourse course = new EthicalHackingCourse();
        course.run();
    }
}
