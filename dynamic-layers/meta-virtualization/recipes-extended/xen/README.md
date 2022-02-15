# SPDX-License-Identifier: MIT

To build a Yocto image with the virtualization support, the
`virtualization-layer` and its dependencies need to be included in the
`conf/bblayer.conf` file and the `conf/local.conf` configuration needs to be
extended with:

This example is for the comhpc machine:
```
MACHINE = "comhpc"
DISTRO_FEATURES:append = " xen virtualization"
```

The image with Xen hypervisor support can be built with:
`bitbake xen-image-minimal`.

Dom0 memory size(in MB) is set with the `DOM0_MEMORY_SIZE` variable. The
dafault value is 4096, and it can be changed by setting this variable in
the `conf/local.conf` file.

For more information about ComHpc platform e.g.: firmware update, see:
[https://docs.ipi.wiki/COMHPC/ava](https://docs.ipi.wiki/COMHPC/ava)

Known Issues:

1. When started on top of Xen, the ITS visible to Linux is modified as Xen is
not allowing exactly the same area to Dom0. As a consequence, Linux finds a
difference with what is given in the ACPI tables and prints this warning per
CPU:
```
[    0.405911] Detected PIPT I-cache on CPU31
[    0.406014] GICv3: CPU31: found redistributor 10f region 0:0x0000100100520000
[    0.412646] ------------[ cut here ]------------
[    0.412647] WARNING: CPU: 31 PID: 0 at drivers/irqchip/irq-gic-v3-its.c:3074 its_cpu_init+0x814/0xae0
[    0.412655] Modules linked in:
[    0.412658] CPU: 31 PID: 0 Comm: swapper/31 Tainted: G        W         5.15.23-ampere-lts-standard #1
[    0.412662] pstate: 600001c5 (nZCv dAIF -PAN -UAO -TCO -DIT -SSBS BTYPE=--)
[    0.412666] pc : its_cpu_init+0x814/0xae0
[    0.412669] lr : its_cpu_init+0x810/0xae0
[    0.412672] sp : ffff800009bbbce0
[    0.412673] x29: ffff800009bbbce0 x28: 000000000000001f x27: ffff880711fa0000
[    0.412678] x26: ffff80000a3e0070 x25: fffffc1ffe0a4800 x24: ffff80000a3e0000
[    0.412682] x23: ffff80000957c198 x22: ffff80000906e000 x21: ffff80000980db28
[    0.412686] x20: ffff8000096bffd8 x19: ffff8000096bf000 x18: ffffffffffffffff
[    0.412690] x17: 3030303235303031 x16: 3030313030303078 x15: 303a30206e6f6967
[    0.412694] x14: 6572206630312072 x13: 3030303032353030 x12: 3130303130303030
[    0.412698] x11: 78303a30206e6f69 x10: 6765722066303120 x9 : ffff800008706b00
[    0.412702] x8 : 6964657220646e75 x7 : 0000000000000003 x6 : 0000000000000000
[    0.412706] x5 : 0000000000000000 x4 : fffffc0000000000 x3 : 0000000000000010
[    0.412709] x2 : 000000000000ffff x1 : 0000000000010000 x0 : 00000000ffffffed
[    0.412714] Call trace:
[    0.412715]  its_cpu_init+0x814/0xae0
[    0.412718]  gic_starting_cpu+0x48/0x90
[    0.412723]  cpuhp_invoke_callback+0x16c/0x5b0
[    0.412727]  cpuhp_invoke_callback_range+0x78/0xf0
[    0.412730]  notify_cpu_starting+0xbc/0xdc
[    0.412733]  secondary_start_kernel+0xe0/0x170
[    0.412737]  __secondary_switched+0x94/0x98
[    0.412741] ---[ end trace f68728a0d3053b71 ]---
[    0.412748] GICv3: CPU31: using allocated LPI pending table @0x0000080002920000
[    0.412835] arch_timer: Enabling local workaround for ARM erratum 1418040
[    0.412846] Xen: initializing cpu31
[    0.412876] CPU31: Booted secondary processor 0x000000010f [0x413fd0c1]
```

2. Xen modifies the IORT table but fails to update the checksum properly:
```
[    0.009029] ACPI: Core revision 20200925
[    0.013288] ACPI BIOS Warning (bug): Incorrect checksum in table [IORT] - 0x95, should be 0xB3 (20200925/tbprint-173)
```

3. The IOREGs are not supported so there is no area allocated to it for Linux.
As a consequence Linux cannot allocate space for the IOREGs and Linux is
failing to allocate them:
```
[    7.972358] PCI host bridge to bus 000c:00
[    7.976417] pci_bus 000c:00: root bus resource [mem 0x40000000-0x4fffffff window]
[    7.984020] pci_bus 000c:00: root bus resource [mem 0x300000000000-0x33ffdfffffff window]
[    7.992274] pci_bus 000c:00: root bus resource [bus 00-ff]
[    7.997845] pci 000c:00:00.0: [1def:e100] type 00 class 0x060000
[    8.003960] pci 000c:00:00.0: Failed to add - passthrough or MSI/MSI-X might fail!
[    8.011577] pci 000c:00:01.0: [1def:e101] type 01 class 0x060400
[    8.017653] pci 000c:00:01.0: supports D1 D2
[    8.021910] pci 000c:00:01.0: PME# supported from D0 D1 D3hot
[    8.027785] pci 000c:00:01.0: Failed to add - passthrough or MSI/MSI-X might fail!
[    8.036530] pci_bus 000c:00: on NUMA node 0
[    8.036534] pci 000c:00:01.0: bridge window [io  0x1000-0x0fff] to [bus 01] add_size 1000
[    8.044734] pci 000c:00:01.0: bridge window [mem 0x00100000-0x000fffff 64bit pref] to [bus 01] add_size 200000 add_align 100000
[    8.056330] pci 000c:00:01.0: bridge window [mem 0x00100000-0x000fffff] to [bus 01] add_size 200000 add_align 100000
[    8.067135] pci 000c:00:01.0: BAR 8: assigned [mem 0x40000000-0x401fffff]
[    8.073927] pci 000c:00:01.0: BAR 9: assigned [mem 0x300000000000-0x3000001fffff 64bit pref]
[    8.082456] pci 000c:00:01.0: BAR 7: no space for [io  size 0x1000]
[    8.088759] pci 000c:00:01.0: BAR 7: failed to assign [io  size 0x1000]
[    8.095450] pci 000c:00:01.0: BAR 7: no space for [io  size 0x1000]
[    8.101781] pci 000c:00:01.0: BAR 7: failed to assign [io  size 0x1000]
[    8.108476] pci 000c:00:01.0: PCI bridge to [bus 01]
[    8.113479] pci 000c:00:01.0:   bridge window [mem 0x40000000-0x401fffff]
[    8.120367] pci 000c:00:01.0:   bridge window [mem 0x300000000000-0x3000001fffff 64bit pref]
[    8.128898] pci_bus 000c:00: resource 4 [mem 0x40000000-0x4fffffff window]
[    8.135818] pci_bus 000c:00: resource 5 [mem 0x300000000000-0x33ffdfffffff window]
[    8.143468] pci_bus 000c:01: resource 1 [mem 0x40000000-0x401fffff]
[    8.149783] pci_bus 000c:01: resource 2 [mem 0x300000000000-0x3000001fffff 64bit pref]
```
